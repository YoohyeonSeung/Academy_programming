# chap13_Factor_Correlation_Analysis

###########################################
# Chapter 13_1. 요인분석(Factor Analysis)
###########################################

# 요인분석의 목적 
# 1. 자료의 요약 : 변인을 몇 개의 공통된 변인으로 묶음  
# 2. 변인 구조 파악 : 변인들의 상호관계 파악(독립성 등) 
# 3. 불필요한 변인 제거 : 중요도가 떨어진 변수 제거 
# 4. 측정도구 타당성 검증 : 변인들이 동일한 요인으로 묶이는지 여부를 확인 

# 전제조건 : 등간척도 or 비율척도, 정규분포, 관찰치 상호독립적/분산 동일  

# 요인분석 결과에 대한 활용 방안 
# 1. 서로 밀접하게 관련된 변수들을 합치거나 중복된 변수를 제거하여 변수를 축소한다.
# 2. 변수들 간의 연관성 또는 공통점 탐색 
# 3. 요인점수 계산으로 상관분석, 회귀분석의 설명변수로 이용 


# [실습] 요인분석에 사용될 데이터 셋 가져오기 

# (1) 데이터 가져오기 
install.packages('memisc')
library(memisc)
setwd("C:/workspaces/Rwork/data")
data.spss <- as.data.set(spss.system.file('drinking_water.sav'))
data.spss

# (2) 데이터프레임으로 변경 
drinking_water <- data.spss[1:11]
drinking_water
drinking_water_df <- as.data.frame(drinking_water) 
str(drinking_water_df)

# (3)  요인수를 3개로 지정하여 요인분석 수행  
result2 <- factanal(drinking_water_df, factors = 3, rotation = "varimax",
                    scores = "regression")
result2
print(result2, cutoff=0.5)


# [실습] 요인별 변수 묶기  

# 1)  q4 칼럼 제외하여 데이터프레임 생성  
dw_df <- drinking_water_df[-4]
str(dw_df)
dim(dw_df) # [1] 380  10
cor(dw_df)

# 2) 요인에 속하는 입력변수별 데이터프레임 구성

# 제품만족도 저장 데이터프레임  
s <- data.frame(dw_df$q8, dw_df$q9, dw_df$q10, dw_df$q11) 
# 제품친밀도 저장 데이터프레임  
c <- data.frame(dw_df$q1, dw_df$q2, dw_df$q3)
# 제품적절성 저장 데이터프레임 
p <- data.frame(dw_df$q5, dw_df$q6, dw_df$q7)   


# 3) 요인별 산술평균 계산 
satisfaction <- round( (s$dw_df.q8 + s$dw_df.q9 + s$dw_df.q10 + s$dw_df.q11) / ncol(s), 2)
closeness <- round( (c$dw_df.q1 + c$dw_df.q2 + c$dw_df.q3) / ncol(c), 2)
pertinence <- round( (p$dw_df.q5 + p$dw_df.q6 + p$dw_df.q7) / ncol(p), 2)




# 4) 상관관계 분석 
drinking_water_factor_df <- data.frame(satisfaction, closeness, pertinence)
drinking_water_factor_df
colnames(drinking_water_factor_df) <- c("제품만족도","제품친밀도","제품적절성")
cor(drinking_water_factor_df)

help(cor)



######################################################
## Chapter 13_2. 상관관계 분석(Correlation Analysis)
######################################################

# 1. 상관관계 분석 수행

# 기술 통계량 구하기 

result <- read.csv("C:/workspaces/Rwork/data/product.csv", header = T)
head(result) # 제품_친밀도,제품_적절성,제품_만족도(등간척도 - 5점 척도)

# 기술통계량 
summary(result) # 요약통계량 

sd(result$제품_친밀도); sd(result$제품_적절성); sd(result$제품_만족도)
# 0.9703446 ; 0.8596574 ; 0.8287436


# 상관계수(coefficient of correlation): 두 변량 X,Y 사이의 상관관계 정도를 나타내는 수치(계수).
cor(result$제품_친밀도, result$제품_적절성) # 0.4992086
cor(result$제품_친밀도, result$제품_만족도) # 0.467145


# 적절성+친밀도 -> 만족도 상관계수 보기 
cor(result$제품_적절성+result$제품_친밀도, result$제품_만족도)
# [1] 0.7017394


# 전체 변수 간 상관계수 보기
cor(result)
#             제품_친밀도 제품_적절성 제품_만족도
#제품_친밀도   1.0000000   0.4992086   0.4671450
#제품_적절성   0.4992086   1.0000000   0.7668527
#제품_만족도   0.4671450   0.7668527   1.0000000


# 방향성 있는 색상으로 표현 
install.packages("corrgram")
library(corrgram)

corrgram(result) # 색상 적용 - 동일 색상으로 그룹화 표시.
corrgram(result, upper.panel = panel.conf) # 상관계수 추가(위쪽)
corrgram(result, lower.panel = panel.conf) # 상관계수 추가(위쪽)

# 차트에 밀도 곡선, 상관성, 유의 확률(별표) 추가 
install.packages("PerformanceAnalytics")
library(PerformanceAnalytics)

# 상관성, p값(*), 정규분포 시각화 - 모수 검정 조건 
chart.Correlation(result, pch="+")

