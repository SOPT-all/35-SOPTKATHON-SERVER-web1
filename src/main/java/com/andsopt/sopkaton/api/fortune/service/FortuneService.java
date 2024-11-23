package com.andsopt.sopkaton.api.fortune.service;

import com.andsopt.sopkaton.api.enums.Gender;
import com.andsopt.sopkaton.api.fortune.dto.response.AnthropicResponse;
import com.andsopt.sopkaton.api.fortune.dto.response.FortuneResponse;
import com.andsopt.sopkaton.db.calender.entity.Calender;
import com.andsopt.sopkaton.db.calender.repository.CalenderRepository;
import com.andsopt.sopkaton.db.card.entity.Card;
import com.andsopt.sopkaton.db.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class FortuneService {

    @Value("${anthropic.api.key}")
    private String key;

    @Value("${anthropic.api.url}")
    private String url;

    @Value("${anthropic.api.model}")
    private String model;

    private final CalenderRepository calenderRepository;

    private final CardRepository cardRepository;

    public FortuneResponse createFortune(final String name, final String birth, final boolean isLunar, final String period, final Gender gender, final String today, final String tomorrow, final String afterTomorrow) {

        StringTokenizer tokenizer = new StringTokenizer(birth, ".");

        String birthYear = tokenizer.nextToken();
        String birthMonth = tokenizer.nextToken();
        String birthDay = tokenizer.nextToken();

        tokenizer = new StringTokenizer(today, ".");

        String todayYear = tokenizer.nextToken();
        String todayMonth = tokenizer.nextToken();
        String todayDay = tokenizer.nextToken();

        tokenizer = new StringTokenizer(tomorrow, ".");

        String tomorrowYear = tokenizer.nextToken();
        String tomorrowMonth = tokenizer.nextToken();
        String tomorrowDay = tokenizer.nextToken();

        tokenizer = new StringTokenizer(afterTomorrow, ".");

        String afterTomorrowYear = tokenizer.nextToken();
        String afterTomorrowMonth = tokenizer.nextToken();
        String afterTomorrowDay = tokenizer.nextToken();

        final Calender birthCalender = getBirthCalender(isLunar, birthYear, birthMonth, birthDay);
        final Calender todayCalender = calenderRepository.findByBirthYearAndBirthMonthAndBirthDay(todayYear, todayMonth, todayDay);
        final Calender tomorrowCalender = calenderRepository.findByBirthYearAndBirthMonthAndBirthDay(tomorrowYear, tomorrowMonth, tomorrowDay);
        final Calender afterTomorrowCalender = calenderRepository.findByBirthYearAndBirthMonthAndBirthDay(afterTomorrowYear, afterTomorrowMonth, afterTomorrowDay);

        final Card findCard = cardRepository.findByTenYears(birthCalender.getGanjiDayKo().substring(0, 1));

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", key);
        headers.set("anthropic-version", "2023-06-01");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = getMapHttpEntity(headers, birthCalender, todayCalender, tomorrowCalender, afterTomorrowCalender, name, gender.getGender());
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AnthropicResponse> response = restTemplate.postForEntity(
                url,
                entity,
                AnthropicResponse.class
        );

        System.out.println("response.getBody() = " + response.getBody());

        // 정규식으로 <태그> </태그> 사이의 내용을 추출
        Pattern pattern = Pattern.compile("<(\\w+)>\\s*(.*?)\\s*</\\1>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response.getBody().content().getFirst().text());

        List<String> extractedContents = new ArrayList<>();

        while (matcher.find()) {
            String tag = matcher.group(1); // 태그 이름
            String content = matcher.group(2); // 태그 사이의 내용
            extractedContents.add(content.trim());
        }

        return FortuneResponse.builder()
                .name(name)
                .todayDate(today)
                .lastDate(afterTomorrow)
                .cardName(findCard.getName())
                .mainCardImageUrl(findCard.getMainImageUrl())
                .subCardImageUrl(findCard.getSubImageUrl())
                .cardContent(extractedContents.get(0))
                .moneyContent(extractedContents.get(1))
                .cautionContent(extractedContents.get(2))
                .notableContent(extractedContents.get(3))
                .totalContent(extractedContents.get(4))
                .build();
    }

    private HttpEntity<Map<String, Object>> getMapHttpEntity(final HttpHeaders headers, final Calender birthCalender, final Calender todayCalender, final Calender tomorrowCalender, final Calender afterTomorrowCalender, final String name, final String gender) {
        String birthYear = birthCalender.getGanjiYearHan() + birthCalender.getGanjiYearKo();
        String birthMonth = birthCalender.getGanjiMonthHan() + birthCalender.getGanjiMonthKo();
        String birthDay = birthCalender.getGanjiDayHan() + birthCalender.getGanjiDayKo();

        String todayYear = todayCalender.getGanjiYearHan() + todayCalender.getGanjiYearKo();
        String todayMonth = todayCalender.getGanjiMonthHan() + todayCalender.getGanjiMonthKo();
        String todayDay = todayCalender.getGanjiDayHan() + todayCalender.getGanjiDayKo();

        String tomorrowYear = tomorrowCalender.getGanjiYearHan() + tomorrowCalender.getGanjiYearKo();
        String tomorrowMonth = tomorrowCalender.getGanjiMonthHan() + tomorrowCalender.getGanjiMonthKo();
        String tomorrowDay = tomorrowCalender.getGanjiDayHan() + tomorrowCalender.getGanjiDayKo();

        String dayAfterTomorrowYear = afterTomorrowCalender.getGanjiYearHan() + afterTomorrowCalender.getGanjiYearKo();
        String dayAfterTomorrowMonth = afterTomorrowCalender.getGanjiMonthHan() + afterTomorrowCalender.getGanjiMonthKo();
        String dayAfterTomorrowDay = afterTomorrowCalender.getGanjiDayHan() + afterTomorrowCalender.getGanjiDayKo();

        String template = """
                나는 1000년에 한 번 나올까 말까 한 사주의 명인으로서, 사용자와 친근한 반말로 소통하며 사주 운세를 해석하는 역할을 수행합니다.
                - 따뜻하고 친근한 어조 사용
                - 귀엽고 발랄한 말투
                - 사용자의 이야기에 공감하는 태도
                전문적이면서도 이해하기 쉬운 설명 방식
                                
                응답 구조
                                
                기본 사주 분석
                - 일간(본인) 특성 설명
                - 오행의 기운 해석
                - 십이운성의 영향 분석
                                
                연애운 분석
                - 현재의 인연 패턴 파악
                - 이상형 분석
                - 주의사항 제시
                                
                시기별 운세
                - 현재 운세의 흐름
                - 해당 연도의 특징적 기운
                - 주요 변화점 예측
                                
                조언과 행운 아이템
                - 운세 상승을 위한 조언
                - 피해야 할 요소들
                - 행운의 색과 방향 제시
                                
                응답 원칙
                - 이해하기 쉬운 분석
                - 전문 용어 사용시 쉬운 비유나 설명 포함
                - 실생활에 적용 가능한 구체적 예시 제시
                                
                긍정적 마무리
                - 각 분석마다 희망적 메시지 포함
                - 발전 가능성과 잠재력 강조
                                
                미래 제시
                - 구체적 시기나 사건보다는 방향성 제시
                - 사용자의 선택과 노력의 중요성 강조
                                
                필수 정보 요청
                아래 항목들을 요청:
                사용자 정보
                - 이름
                - 성별
                - 연주
                - 월주
                - 일주
                오늘 간지 정보
                - 연주
                - 월주
                - 일주
                내일 간지 정보
                - 연주
                - 월주
                - 일주
                모레 간지 정보
                - 연주
                - 월주
                - 일주
                                
                주의사항
                - 지나치게 부정적인 해석 지양
                - 무조건 반말로 친절하게 안내
                - 단정적 표현보다는 가능성 위주의 표현 사용
                - 사용자의 자유의지와 선택을 존중하는 해석 제공
                - 미신적이거나 비과학적인 조언 제한
                - 위의 구조와 원칙에 따라, 사용자의 사주를 분석하고 이해하기 쉽게 설명하며, 항상 긍정적이고 희망적인 메시지로 마무리합니다.
                - 각 섹션은 350자 이상 400자 이내로 작성
                                
                사용자 정보:
                - 이름: {{.Name}}
                - 성별: {{.Gender}}
                - 연주: {{.UYearGapJa}}
                - 월주: {{.UMonthGapJa}}
                - 일주: {{.UDayGapJa}}

                오늘의 간지 정보:
                - 연주: {{.TodayYear}}
                - 월주: {{.TodayMonth}}
                - 일주: {{.TodayDay}}

                내일의 간지 정보:
                - 연주: {{.TomorrowYear}}
                - 월주: {{.TomorrowMonth}}
                - 일주: {{.TomorrowDay}}

                모레의 간지 정보:
                - 연주: {{.DayAfterTomorrowYear}}
                - 월주: {{.DayAfterTomorrowMonth}}
                - 일주: {{.DayAfterTomorrowDay}}
                                
                기본 사주 분석, 금전운 분석, 연애운 분석, 시기별 운세, 조언과 행운 아이템을 다음의 형식으로 응답오게 해줘
                                
                <standard>
                [오늘부터 내일, 모레까지의 운세에 대한 총평을 사용자의 일주(특히)적인 기질에 기반하여 이야기. 타이틀 없이]
                </standard>          
                                
                <money_luck>
                [3일간의 금전운 흐름을 하나의 연결된 이야기로 서술. 시간의 흐름에 따른 변화와 대응방안을 자연스럽게 설명]
                </money_luck>
                                
                <caution>
                [3일 동안 특별히 주의해야 할 사항들을 시간의 흐름에 따라 자연스럽게 연결하여 설명. 각 상황의 인과관계와 대처 방안을 포함]
                </caution>
                                
                <life_guide>
                [3일간의 생활 지침을 하나의 통합된 조언으로 제시. 시간의 흐름에 따른 변화를 고려하면서도 일관된 방향성을 제시]
                </life_guide>
                                
                <happiness>
                [3일간의 행복과 전반적인 운세를 종합적으로 서술하고, 긍정적인 변화의 흐름을 제시. 마지막에 따뜻한 응원의 메시지로 마무리]
                [이름]아~ 이렇게 네 운세를 봐줬어. 행운이 가득하길 바랄게!
                </happiness>
                """;

        String content = template
                .replace("{{.Name}}", name)
                .replace("{{.Gender}}", gender)
                .replace("{{.UYearGapJa}}", birthYear)
                .replace("{{.UMonthGapJa}}", birthMonth)
                .replace("{{.UDayGapJa}}", birthDay)
                .replace("{{.TodayYear}}", todayYear)
                .replace("{{.TodayMonth}}", todayMonth)
                .replace("{{.TodayDay}}", todayDay)
                .replace("{{.TomorrowYear}}", tomorrowYear)
                .replace("{{.TomorrowMonth}}", tomorrowMonth)
                .replace("{{.TomorrowDay}}", tomorrowDay)
                .replace("{{.DayAfterTomorrowYear}}", dayAfterTomorrowYear)
                .replace("{{.DayAfterTomorrowMonth}}", dayAfterTomorrowMonth)
                .replace("{{.DayAfterTomorrowDay}}", dayAfterTomorrowDay);

        Map<String, Object> body = Map.of(
                "model", model,
                "max_tokens", 2048,
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", content
                        )
                )
        );

        return new HttpEntity<>(body, headers);
    }

    private Calender getBirthCalender(final boolean isLunar, final String birthYear, final String birthMonth, final String birthDay) {
        if (isLunar) {
            return calenderRepository.findByBirthYearAndBirthMonthAndBirthDay(birthYear, birthMonth, birthDay);
        }

        return calenderRepository.findByLunarYearAndLunarMonthAndLunarDay(birthYear, birthMonth, birthDay);
    }
}
