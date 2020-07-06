# chap01_Basic

###########################################
##      Chapter01. R의 설치와 개요       ##
###########################################

# 주요 단축키
# - script 실행 : Ctrl + Enter 
# - 저      장  : Ctrl + s


## 3. 패키지와 Session 보기

# R package 보기
dim(available.packages())
available.packages()

# R 세션 보기
sessionInfo()


# 패키지 사용법
install.packages("stringr")
library(stringr) # library("stringr")  # 패키지를 메모리에 로딩 : "" 생략 가능

search()  # 패키지 메모리 로딩 확인.
 
# 패키지 삭제/제거
remove.packages("stringr")
 
# 데이터셋 보기
data()

# 기본 데이터 셋으로 히스토그램 그리기
# 단계 1 : 빈도수(frequency)를 기준으로 히스토그램 그리기.
hist(Nile)

# 단계 2 : 밀도(density)를 기준으로 히스토그램 그리기.
hist(Nile, freq=False)   # default는 true

# 단계 3 : 단계2의 결과에 분포곡선(line)을 추가
lines(density(Nile))



# 히스토그램을 파일로 저장하기.
par(mfrow=c(1,1))  # plot영역에 1개의 그래프 표시
pdf("C://workspaces//Rwork//output//batch.pdf")
hist(rnorm(20)) # 난수에 대한 히스토그램 그리기
dev.off()

## 4. 변수와 자료형
age <- 25
age <- "홍길동"
age <- 35
age

# 변수 . 멤버 형태로 변수 선언 예
goods.model <- "lg-320"   # 상품 모델명
goods.name <- "냉장고"
goods.price <- 850000
goods.desc <- "동급 최고 품질/사양"


# 자료형
int <- 20           # 숫자형(정수)
double <- 3.14      # 숫자형(실수)
string <- "홍길동"  # 문자형
boolean <- TRUE     # 진리값 : TRUE(T) 또는 FALSE(F)

int; boolean; double; string

boolean <- 5.26
boolean


# 자료형 확인   -   pdf 0.3 개요 7페이지 참고
is.character(int)    # 문자형일 경우 T, 문자형이 아닐 경우 F 출력
is.character(string)
is.character("boolean")


# 문자 원소를 숫자 원소로 형변환
x <- c(1, 2, 3)
x    # 실행결과 : 1 2 3

y <- c(1,2,"3")
y    # 실행결과 : "1" "2" "3"

result <- x * 3
result

result <- y * 5
# Error in y * 5 : non-numeric argument to binary operator

result <- as.integer(y) * 3     


# 복소수형 자료 생성과 형변환
z <- 5.3 - 3i
Re(z); Im(z)
is.complex(z)      # TRUE
as.complex(5.3)    # 5.3+0i


# 스칼라 변수의 자료형
mode(int)       # "numeric"
mode(string)    # "character"
mode(boolean)   # "logical"



# 문자 벡터와 그래프 생성
gender <- c('man', 'woman', 'woman', 'man','man')
gender

mode(gender)       # "character"
class(gender)      # "character"

plot(gender)       # error

iris$Species
# as.factor() 함수 이용 범주(요인)형 변환
Ngender <- as.factor(gender)
Ngender
table(Ngender)

# Factor형 변수로 차트 그리기
plot(Ngender)
mode(Ngender)       # "numeric"
class(Ngender)      # "factor"
is.factor(Ngender)  # TRUE

# Factor Nominal 변수
Ngender

# factor() 함수 이용 Factor 형 변환
args(factor)
Ogender <- factor(gender, levels=c('woman', 'man'), ordered =  T)
Ogender

# 순서 없는 요인과 순서 있는 요인형 변수로 차트 그리기
par(mfrow=c(1,2))
plot(Ngender)
plot(Ogender)


# 도움말 보기
i <- sum(1,2,3)
i

help(sum)
?sum

# 함수 파라메터 보기
args(sum)

# 함수 사용 예제 보기
example(sum)

# 작업 공간 지정
getwd()
setwd("c://workspaces//Rwork//output")















