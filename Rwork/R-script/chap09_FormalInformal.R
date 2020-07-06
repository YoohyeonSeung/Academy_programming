# chap09_FormalInformal

########################################
##  Chapter09. 정형/비정형 데이터 처리  
########################################

## 1.1 Oracle 정형 데이터 처리 

# 단계1 : 사용자 로그인과 테이블 생성.
#  - sqlplus 명령문으로 접속 후 다음의 테이블 생성.

#SQL> create table test_table(
#  2  id    varchar2(50)  primary key,
#  3  pass  varchar2(30)  not null,
#  4  name  varchar2(30)  not null,
#  5  age   number(2)
#  6  );

# 단계2 : 레코드 추가와 조회하기.
#SQL>insert into test_table values('hong', '1234', '홍길동', 25);
#SQL>insert into test_table values('lee', '1234', '이순신', 30);

# 단계3 : transaction 처리 - commit;
#SQL> commit;

## Oracle 연동을 위한 R 패키지 설치.

# 1) 패키지 설치 
#   - RJDBC 패키지를 사용하기 위해서는 우선 java를 설치해야 한다.
install.packages("rJava")
install.packages("DBI")
install.packages("RJDBC")

# 2) 패키지 로딩 
library(DBI)
Sys.setenv(JAVA_HOME='C:/Program Files/Java/jre1.8.0_191')
library(rJava)
library(RJDBC) # rJava에 의존적이다(rJava 먼저 로딩).

# 3) Oracle 연동 

######### Oracle 11g  #################
# driver
drv <- JDBC("oracle.jdbc.driver.OracleDriver", 
     "C:/oraclexe/app/oracle/product/11.2.0/server/jdbc/lib/ojdbc6.jar")

# db 연동(driver, url, id, pwd)
conn <- dbConnect(drv, "jdbc:oracle:thin:@//127.0.0.1:1521/xe", "scott", "tiger")
#######################################


# 1. 모든 레코드 검색 
query <- "select * from test_table"
dbGetQuery(conn, query)


# 2. 정렬 조회 - 나이 컬럼을 기준으로 내림차순 정렬
query = "select * from test_table order by age desc"
dbGetQuery(conn, query)

# 3. 레코드 삽입 
query = "insert into test_table values('kang', '1234', '강감찬', 35)"
dbSendUpdate(conn, query)

query = "select * from test_table"
dbGetQuery(conn, query)


# 4. 조건 검색 - 나이가 35세 이상인 레코드 조회
query <- "select * from test_table where age >= 35"
result <- dbGetQuery(conn, query)
result
View(result)


# 5. 레코드 수정 : 데이터 '강감찬'의 나이를 40으로 수정.
query <- "update test_table set age = 40 where name = '강감찬'"
dbSendUpdate(conn, query)

query <- "select * from test_table"
dbGetQuery(conn, query)


# 6. 레코드 삭제 - 데이터 '홍길동' 레코드 삭제
query <- "delete from test_table where name='홍길동'"
dbSendUpdate(conn, query)

query <- "select * from test_table"
dbGetQuery(conn, query)


# 7. db 연결 종료
dbDisconnect(conn)


## 2.1 토픽 분석 
#    - 텍스트 데이터를 대상으로 단어를 추출하고, 이를 단어 사전과 비교하여 단어의 출현 빈도수를 분석하는 텍스트마이닝 분석 과정을 의미한다.
#    - 또한 단어구름(word cloud) 패키지를 적용하여 분석 결과를 시각화하는 과정도 포함.

install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")

# 패키지 로드

library(KoNLP)
library(dplyr)

# java 폴더 경로 설정
Sys.setenv(JAVA_HOME="C:/Program Files/Java/jre1.8.0_191/")

useNIADic()

# 데이터 불러오기
txt <- readLines("C:/workspaces/Rwork/data/hiphop.txt")
head(txt)

#install.packages("stringr")
library(stringr)

# 특수문제 제거
txt <- str_replace_all(txt, "\\W", " ")


## --------------------------------------------------------- ##
extractNoun("대한민국의 영토는 한반도와 그 부속도서로 한다")

# 가사에서 명사추출
nouns <- extractNoun(txt)

# 추출한 명사 list를 문자열 벡터로 변환, 단어별 빈도표 생성
wordcount <- table(unlist(nouns))

# 데이터 프레임으로 변환
df_word <- as.data.frame(wordcount, stringsAsFactors = F)

# 변수명 수정
df_word <- rename(df_word,
                  word = Var1,
                  freq = Freq)

# 두 글자 이상 단어 추출
df_word <- filter(df_word, nchar(word) >= 2)

top_20 <- df_word %>%
  arrange(desc(freq)) %>%
  head(20)

top_20


## ----------------------------------------------------------- ##
# 패키지 설치
install.packages("wordcloud")

# 패키지 로드
library(wordcloud)
library(RColorBrewer)

pal <- brewer.pal(8,"Dark2")  # Dark2 색상 목록에서 8개 색상 추출

set.seed(1234)
wordcloud(words = df_word$word,  # 단어
          freq = df_word$freq,   # 빈도
          min.freq = 2,          # 최소 단어 빈도
          max.words = 200,       # 표현 단어 수
          random.order = F,      # 고빈도 단어 중앙 배치
          rot.per = .1,          # 회전 단어 비율
          scale = c(4, 0.3),     # 단어 크기 범위
          colors = pal)          # 색깔 목록

pal <- brewer.pal(9,"Blues")[5:9]  # 색상 목록 생성
set.seed(1234)                     # 난수 고정

wordcloud(words = df_word$word,    # 단어
          freq = df_word$freq,     # 빈도
          min.freq = 2,            # 최소 단어 빈도
          max.words = 200,         # 표현 단어 수
          random.order = F,        # 고빈도 단어 중앙 배치
          rot.per = .1,            # 회전 단어 비율
          scale = c(4, 0.3),       # 단어 크기 범위
          colors = pal)            # 색상 목록


"""
# 텍스트마이닝을 위한 패키지 설치 
# install.packages("rJava")
Sys.setenv(JAVA_HOME='C:/Program Files/Java/jre1.8.0_191')
library(rJava) # 메모리 로딩 

remove.packages(c("KoNLP", "wordcloud"))
remove.packages("tm")
remove.packages("slam")

# 토픽 분석을 위한 패키지 설치 
install.packages(c("KoNLP", "wordcloud")) # Korean Natural Language Processing(한글 텍스트 마이닝)

install.packages("slam")
install.packages("tm") # 영문 텍스트 마이닝 
#install.packages("http://cran.r-project.org/bin/windows/contrib/3.0/slam_0.1-32.zip", repos=NULL)
#install.packages("http://cran.r-project.org/bin/windows/contrib/3.0/tm_0.5-10.zip", repos=NULL)

library(slam)
library(tm) # tm 패키지는 slam 패키지에 의존적임.

library(KoNLP) # 세종사전 / NIA 사전 
library(wordcloud) # RColorBrewer() 함수 제공 


# 명사 추출 예
extractNoun('안녕하세요. 홍길동 입니다.')
extractNoun("텍스트마이닝이란 텍스트에서 유용한 정보를 찾아내는 과정을 말한다.")


# 텍스트 자료 가져오기 
facebook <- file("C:/workspaces/Rwork/data/facebook_bigdata.txt", encoding = "UTF-8")
facebook_data <- readLines(facebook) # 줄 단위 데이터 생성 
close(facebook)

head(facebook_data) # 앞부분 6줄 보기 - 줄 단위 문장 확인
str(facebook_data) # chr [1:76]


# 자료집(Corpus) 생성.
facebook_corpus <- Corpus(VectorSource(facebook_data)) # 벡터 데이터를 대상으로 자료집(documents)을 생성.
facebook_corpus
inspect(facebook_corpus)


# 단어 추가와 단어 추출
#  (1) 세종 사전 사용 및 단어 추가 
install.packages("curl")
library(curl)

useSejongDic() # 세종 사전 불러오기(370957 words)

#  (2) 세종 사전에 없는 단어 추가  
# mergeUserDic(data.frame(c("R 프로그래밍", "페이스북", "소셜네트워크"), c("ncn")))  # ncn : 명사지시코드 


# 단어추출 사용자 함수 정의 
#  (1) 사용자 정의 함수 작성 
#      - [문자변환] ->[단어추출]->[공백으로 합침]
exNouns <- function(x){ 
  paste(extractNoun(as.character(x)), collapse = " ")}

#  (2) exNouns 함수 이용 단어 추출 
help(sapply)
facebook_nouns <- sapply(facebook_corpus, exNouns)
facebook_nouns[1] # 단어만 추출된 첫 줄 보기 

# 추출된 단어 대상 전처리 
#  (1) 추출된 단어 이용 자료집 생성
myCorpusfacebook <- Corpus(VectorSource(facebook_nouns))
myCorpusfacebook

#  (2) 데이터 전처리
myCorpusfacebook <- tm_map(myCorpusfacebook, removePunctuation) # 문장부호 제거
myCorpusfacebook <- tm_map(myCorpusfacebook, removeNumbers) # 수치 제거
myCorpusfacebook <- tm_map(myCorpusfacebook, tolower) # 소문자 변경 
myCorpusfacebook <- tm_map(myCorpusfacebook, removeWords, stopwords('english')) # 불용어제거(for, very, and, of, are)

inspect(myCorpusfacebook[1])


# 단어 선별(단어 길이 2개 이상)
# 전처리된 단어집을 대상으로 일반문서로 변환.
myCorpusfacebook_txt <- tm_map(myCorpusfacebook, PlainTextDocument)

# 단어길이 2개 이상인 단어만 선별하여 matrix 자료구조로 변경
myCorpusfacebook_txt <- TermDocumentMatrix(myCorpusfacebook_txt[1:76], 
                                            control=list(wordLengths=c(2, Inf))) # 텍스트를 숫자로 표현하는 대표적인 방법.

myCorpusfacebook_txt

# matrix 자료구조를 data.frame 자료구조로 변경 
myTermfacebook.df <- as.data.frame(as.matrix(myCorpusfacebook_txt2))
dim(myTermfacebook.df)

# 단어 빈도수 구하기 - 빈도수가 높은 순서대로 내림차순 정렬 
wordResult <- sort(rowSums(myTermfacebook.df), decreasing = T) # 빈도수로 내림차순 정렬 
wordResult[1:10]


# 단어 구름(wordcloud) 생성 - 디자인 적용 전
myName <- names(wordResult) # 단어 이름 생성 -> 빈도수의 이름 
wordcloud(myName, wordResult) # 단어구름 적성 

# 불필요한 단어 제거 시작 
# 1) 데이터 전처리 
myCorpusfacebook <- tm_map(myCorpusfacebook, removePunctuation) # 문장부호 제거
myCorpusfacebook <- tm_map(myCorpusfacebook, removeNumbers) # 수치 제거
myCorpusfacebook <- tm_map(myCorpusfacebook, tolower) # 소문자 변경 
myStopwords = c(stopwords('english'), "사용", "기법")
myCorpusfacebook <- tm_map(myCorpusfacebook, removeWords, myStopwords) # 불용어제거(for, very, and, of, are)
inspect(myCorpusfacebook[1:5]) # 데이터 전처리 결과 확인

# 2) 단어 선별 - 단어 길이 2개 이상 단어 성별
myCorpusfacebook_txt <- tm_map(myCorpusfacebook, PlainTextDocument)
myCorpusfacebook_txt <- TermDocumentMatrix(myCorpusfacebook_txt[1: 76],control = list(wordLengths=c(2, Inf)))

myCorpusfacebook_txt

# matrix -> data.frame 변경
myTermfacebook.df <- as.data.frame(as.matrix(myCorpusfacebook_txt))
dim(myTermfacebook.df) # [1] 847  76


#  3) 단어 빈도수 구하기
# 단어 빈도수 구하기 - 빈도수가 높은 순서대로 내림차순 정렬 
wordResult <- sort(rowSums(myTermfacebook.df), decreasing = T) # 빈도수로 내림차순 정렬 
wordResult[1:10]

#  4) 단어 구름(wordcloud) 생성 - 디자인 적용 전 
myName <- names(wordResult) # 단어 이름 추출(빈도수 이름)
wordcloud(myName, wordResult) # 단어구름 시각화


# 단어 구름에 디자인 적용(빈도수, 색상, 위치, 회전 등)
# (1) 단어 이름과 빈도수로 data.frame 생성
word.df <- data.frame(word=myName, freq=wordResult)
str(word.df) # word.df, freq 변수 


# (2) 단어 색상과 글꼴 지정
pal <- brewer.pal(12, "Paired") # 12가지 색상 pal
windowsFonts(malgun=windowsFont("맑은 고딕"))

# (3) 단어 구름 시각화 - 별도의 창에 색상, 빈도수, 글꼴, 회전 등의 속성 적용 
x11() # 별도의 창을 띄우는 함수
wordcloud(word.df$word, word.df$freq, scale = c(5,1), 
          min.freq = 3, random.order = F, rot.per = .1,
          colors = pal, family="malgun")
"""


## 2.2 연관어 분석

# 한글 처리를 위한 패키지 설치
# install.packages('rJava')
# Sys.setenv(JAVA_HOME='C:/Program Files/Java/jre1.8.0_191')
# library(rJava)

# install.package("KoNLP")
# library(KoNLP) # rJava 라이브러리가 필요함.

# 텍스트 파일 가져오기와 단어 추출하기 
# 1. 텍스트 파일 가져오기
marketing <- file("C:/workspaces/Rwork/data/marketing.txt", encoding = "UTF-8")
marketing2 <- readLines(marketing) # 줄 단위 데이터 생성 

close(marketing)
head(marketing2)

# 2. 줄 단위 단어 추출
lword <- Map(extractNoun, marketing2)
length(lword) # [1] key = 472

lword <- unique(lword) # 중복제거 
length(lword) # [1] 353

str(lword)


# 연관어 분석을 위한 전처리 

# 1) 단어 필터링 함수 정의 - 길이가 2개 이상 4개 이하 사이의 문자 길이로 구성된 단어만 필터링.
filter1 <- function(x){
  nchar(x) >= 2 && nchar(x) <= 4 && is.hangul(x)
}

filter2 <- function(x){
  Filter(filter1, x)
}


# 2) 줄 단위로 추출된 단어 전처리 
lword <- sapply(lword, filter2) # 단어 길이가 1이하 또는 5 이상인 단어 제거.
lword


# 트랜잭션 생성
#  - 트랜잭션:연관분석에서 사용되는 자료 처리 단위 
#  - 연관분석을 위해서는 추출된 단어를 대상으로 트랜잭션 형식으로 자료구조 변환.

# 1) 연관 분석을 위한 패키지 설치 
install.packages("arules")
library(arules)

# 2) 트랜잭션 생성 
wordtran <- as(lword, "transactions")
wordtran

wordtable <- crossTable(wordtran) # 교차표 작성
wordtable

# 단어 간 연관규칙 산출 
tranrules <- apriori(wordtran, parameter = list(support=0.25, conf=0.05)) # writing ... [59 rule(s)] : 59개 규칙 발견.


# 연관 규칙 생성 결과보기
inspect(tranrules) 


# 연관규칙 생성 간단 예문 
data("Adult")
Adult
str(Adult)
dim(Adult) # [1] 48842개 트랜잭션과 115개 아이템

inspect(Adult)

# 특정 항목의 내용을 제외한 itemsets 수 발견
apr1 <- apriori(Adult, parameter = list(support=0.1, target="frequent"),
        appearance = list(none = c("income=small", "income=large"), default="both"))


apr1
inspect(apr1)


# 연관어 시각화 
# 1) 연관 단어 시각화를 위해서 자료 구조 변경 
rules <- labels(tranrules, ruleSep=" ")
head(rules)
class(rules) # [1] "character"

# 2) 문자열로 묶인 연관 단어를 행렬구조 변경.
rules <- sapply(rules, strsplit, " ", USE.NAMES = F)
rules
class(rules)

# 3) 행 단위로 묶어서 matrix로 반환
rulemat <- do.call("rbind", rules)
rulemat


# 연관어 시각화를 위한 igraph 패키지 설치 
install.packages("igraph")
library(igraph)

# edgelist 보기 - 연관 단어를 정점 형태의 목록 제공 
ruleg <- graph.edgelist(rulemat[c(12:59),], directed = F) #[1,]~[11,] "{}" 제외 
ruleg

# edgelist 시각화
x11()
plot.igraph(ruleg, vertext.label=V(ruleg)$name,
            vertex.label.cex=1.2, vertext.label.color='black',
            vertex.size=20, vertex.color='green', 
            vertex.frame.color='blue')

