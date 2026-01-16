package Class_260116;

class Subway {
    String lineName;
    String lineColor;
    String operator;
    String models;
    String inverter;
    String trainRange;

    public Subway(String lineName, String lineColor, String operator, String models, String inverter, String trainRange) {
        this.lineName = lineName;
        this.lineColor = lineColor;
        this.operator = operator;
        this.models = models;
        this.inverter = inverter;
        this.trainRange = trainRange;
    }

    public void introduceSubway() {
        System.out.println("--- " + lineName + " 구동음 및 소자 상세 소개 ---");
        System.out.println("노선 색상 : " + (lineColor != null ? lineColor : "정보 없음"));
        System.out.println("운영 기관 : " + operator);
        System.out.println("제어 소자 : " + inverter);
        System.out.println("주요 차종 : " + models);
        System.out.println("편성 정보 : " + trainRange);
        System.out.println("------------------------------------------");
    }
}

public class SeoulSubway {
    public static void main(String[] args) {
        Subway[] subways = {

                new Subway("1호선", "남색/빨간색", "서울교통공사", "개조저항, VVVF-GTO",
                        "GTO & 저항제어", "101~116편성"),

                new Subway("1호선", "남색/빨간색","코레일", "GTO & IGBT",
                        "311000호대 & 312000호대","311x01~311x90편성 / 312x01~312x09편성"),

                new Subway("2호선", "초록색", "서울교통공사", "로템/다원시스 VVVF",
                        "IGBT", "201~229편성 / 236~239편성 / 260~270편성"),

                new Subway("2호선", "초록색", "서울교통공사", "GEC(광폭/멜코형)",
                        "GEC-Chopper", "230~236편성/ 240~259편성 / 271~295편성"),

                new Subway("3호선", "주황색", "서울교통공사", "로템 VVVF",
                        "IGBT", "301~315편성 / 320~329편성"),

                new Subway("3호선", "주황색", "서울교통공사", "GEC(광폭형)",
                        "GEC-Chopper", "316~319편성 / 330~349편성"),

                new Subway("3호선", "주황색", "코레일", "VVVF-GTO(미쓰비시)",
                        "미쓰비시 VVVF-GTO", "371~388편성"),

                new Subway("4호선", "파란색", "서울교통공사", "현대정공/대우중공업",
                        "미쓰비시 VVVF-GTO", "401~409편성 / 450~459편성"),

                new Subway("4호선", "파란색", "서울교통공사", "대우중공업(직류 전용)",
                        "알스톰 VVVF-GTO", "411~449편성 / 460~463편성"),

                new Subway("4호선", "파란색", "코레일", "GTO & IGBT",
                        "341000호대", "341x01~341x59편성"),

                new Subway("5호선", "보라색", "서울교통공사", "현대정공/로템",
                        "GTO(ABB), IGBT", "501~580편성"),

                new Subway("6호선", "봉숭아색", "서울교통공사", "현대정공",
                        "IGBT", "601~639편성"),

                new Subway("7호선", "진녹색", "서울교통공사", "현대정공/대우중공업/로템",
                        "알스톰 GTO & IGBT", "701~770편성 / 640~641편성"),

                new Subway("8호선", "분홍색", "서울교통공사", "현대정공/대우중공업",
                        "알스톰 GTO & IGBT", "801~820편성")
        };

        for (Subway s : subways) {
            s.introduceSubway();
        }
    }
}