package Class_260115;

class Car {
        String modelName;
        int modelYear;
        String category;

        public Car(String modelName, int modelYear, String category) {
            this.modelName = modelName;
            this.modelYear = modelYear;
            this.category = category;
        }

        public void introduceCar() {
            System.out.println("--- 현대자동차 모델 소개 ---");
            System.out.println("모델명 : " + modelName);
            System.out.println("연식   : " + modelYear + "년형");
            System.out.println("차종   : " + category);
            System.out.println();
        }
    }

    // 파일명과 동일하거나 중복되지 않는 클래스 이름을 사용합니다.
    class _1_Hyundaicar {
        public static void main(String[] args) {
            // Car 객체 생성
            Car car1 = new Car("스타리아", 2026, "MPV(다목적 차량)");
            Car car2 = new Car("코나", 2026, "소형 SUV");
            Car car3 = new Car("팰리세이드", 2026, "대형 SUV");
            Car car4 = new Car("투싼", 2026, "준중형 SUV");
            Car car5 = new Car("싼타페", 2026, "중형 SUV");
            Car car6 = new Car("아이오닉5", 2026, "준중형 SUV (전기차)");
            Car car7 = new Car("아이오닉6", 2026, "중형 세단 (전기차)");
            Car car8 = new Car("제네시스G80", 2026, "대형 세단");
            Car car9 = new Car("베뉴", 2026, "소형 SUV");
            Car car10 = new Car("캐스퍼", 2026, "경형 SUV");
            Car car11 = new Car("그랜저", 2026, "대형 세단");
            Car car12 = new Car("아반떼", 2026, "준중형 세단");
            Car car13 = new Car("쏘나타", 2026, "중형 세단");

            car1.introduceCar();
            car2.introduceCar();
            car3.introduceCar();
            car4.introduceCar();
            car5.introduceCar();
            car6.introduceCar();
            car7.introduceCar();
            car8.introduceCar();
            car9.introduceCar();
            car10.introduceCar();
            car11.introduceCar();
            car12.introduceCar();
            car13.introduceCar();
        }
    }

