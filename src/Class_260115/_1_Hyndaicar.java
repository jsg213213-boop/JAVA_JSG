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

    class _1_Hyundai {
        public static void main(String[] args) {
            // Car 객체 생성
            Car car01 = new Car("스타리아", 2026, "승합차");
            Car car02 = new Car("코나", 2026, "소형 SUV");
            Car car03 = new Car("팰리세이드", 2026, "대형 SUV");
            Car car04 = new Car("투싼", 2026, "준중형 SUV");
            Car car05 = new Car("싼타페", 2026, "중형 SUV");
            Car car06 = new Car("아이오닉5", 2026, "준중형 SUV (전기차)");
            Car car07 = new Car("아이오닉6", 2026, "중형 세단 (전기차)");
            Car car08 = new Car("제네시스G80", 2026, "대형 세단");
            Car car09 = new Car("베뉴", 2026, "소형 SUV");
            Car car10 = new Car("캐스퍼", 2026, "경형 SUV");
            Car car11 = new Car("그랜저", 2026, "대형 세단");
            Car car12 = new Car("아반떼", 2026, "준중형 세단");
            Car car13 = new Car("쏘나타", 2026, "중형 세단");

            car01.introduceCar();
            car02.introduceCar();
            car03.introduceCar();
            car04.introduceCar();
            car05.introduceCar();
            car06.introduceCar();
            car07.introduceCar();
            car08.introduceCar();
            car09.introduceCar();
            car10.introduceCar();
            car11.introduceCar();
            car12.introduceCar();
            car13.introduceCar();
        }
    }

