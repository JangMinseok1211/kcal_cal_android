# 프로젝트 기술서

&nbsp;

&nbsp;

&nbsp;

### 1. 소개(Introduction)
 **-1.1	App의 목적 (Purpose is App)**
    이 어플리케이션의 목적은 사용자들의 식단을 관리하고 칼로리, 3대 영양소 측정을 보다 간편하게 하기 위함이다
 **-1.2	산출물의 범위 (Scope of product)**
    “칼로리 계산기”는 사용자에게 그날의 식단을 입력 받아 영양소와 칼로리를 계산해주는 어플리케이션이다.
&nbsp;

&nbsp;
    
### 2. 일반적인 기술 사항(General Description)
  **-2.1	제품의 관점 (Product Perspective)**
    해당 어플은 기존에 사용하던 칼로리 계산 어플을 어려워하는 사용자들을 위해 보다 간편하게 사용하고자 고안되었다. 매일매일을 기록하 
    며 저장하면 한눈에 보기 힘들기에 해당 애플리케이션의 필요성이 대두되었다.
  **-2.2	사용자 특성 (User Characteristics)**
    어플의 사용자는 어플 내에서 자신의 그날의 식단을 검색하고 추가할 수 있어야 한다. 고객은 다음과 같은 기능을 수행할 수 있어야 한다.
    
    날짜 선택 기능
    전에 입력 했던 식단의 칼로리 볼 수 있음
    하루 식단 입력
    그날의 아침, 점심, 저녁의 메뉴를 입력

 **-2.3	제약사항 (Constraints)**
    Java와 안드로이드 스튜디오를 이용해 안드로이드 스마트폰용 애플리케이션을 구현한다
    입력된 데이터를 관리할 내장 데이터베이스를 위해 SQLite나 MariaDB를 사용한다.
    음식의 데이터를 관리할 JSON을 사용한다.
    안드로이드 최신 버전을 기준으로 한다.

&nbsp;

&nbsp;

### 3. 요구사항(Requirements)
**-3.1	기능적 요구사항(Functional Requirement One)**
    음식 데이터 관리 : 어플리케이션은 음식 데이터를 JSON 형식으로 관리합니다.
    음식의 이름, 칼로리, 3대 영양소(탄수화물, 단백질, 지방)등의 정보가 포함됩니다.
    
    음식검색 : 사용자가 입력한 키워드나 카테고리를 기반으로 음식 데이터베이스에서 음식을 검색합니다.
    검색결과는 사용자에게 제공되며, 선택한 음식은 칼로리와 영양소 계산에 사용됩니다.
    
    칼로리 및 영양소 계산 : 사용자가 음식을 선택하면 어플리케이션은 해당 음식의 칼로리, 탄수화물, 단백질, 지방 등의 영양소 값을 계산 
    합니다. 이를 위해 음식 데이터베이스에서 해당 음식의 정보를 조회하고 계산합니다.
    
    사용자 음식 입력 : 사용자는 직접 음식을 입력할 수도 있습니다. 사용자가 입력한 음식의 이름과 해당 음식에 대한 칼로리, 영양소 정보 
    를 저장하고 계산합니다.

    음식 기록 및 저장 : 사용자가 섭취한 음식을 기록하고 저장할 수 있습니다. 음식 기록은 사용자의 섭취 칼로리와영양소 섭취량을 추적하 
    기위해 사용됩니다
**-3.2	사용자 요구사항(Usability Requirement One)**
    어플의 사용자는 어플 내에서 자신의 그날의 식단을 검색하고 추가할 수 있어야 한다. 고객은 다음과 같은 기능을 수행할 수 있어야 한다.
    
    날짜 선택 기능
    전에 입력 했던 식단의 칼로리 볼 수 있음
    하루 식단 입력
    그날의 아침, 점심, 저녁의 메뉴를 입력


**-3.3	신뢰성 요구사항(Reliability Requirement One)**
    음식 데이터베이스는 정확하고 최신의 정보를 포함해야 합니다. 영양소 값을 정확성을 유지하기 위해 신뢰할 수 있는 데이터 소스를 사용 
    하거나 영양소 데이터베이스를 참조해야 합니다.
**-3.4	성능 요구사항 (Performance Requirement One)**
    어플리케이션은 음식 데이터를 효율적으로 관리하고, 음식 검색 및 칼로리 계산 등의 기능을 빠르게 수행해야 합니다. 데이터베이스 쿼리 
    최적화, 캐싱, 비동기 처리 등을 고려하여 성능을 향상시킵니다.

# team5
team5/ project

6월12일 19시 현재 평가자료를 위해 확정합니다. -이귀봉-
