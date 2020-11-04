#key = value 
driver = com.mysql.jdbc.Driver
url = jdbc:mysql://*******.com:3306/*****?useSSL=false
username = ****
password = ****
ID = CODE
#sql = select us_id from us where time>=? and time<=?
#sql = SELECT CODE, NAME, t.EXT_ATTR_22 JOIN_DATE FROM ORG_MEMBER t WHERE t.CODE is not null;
#sql = SELECT CODE FROM ORG_MEMBER WHERE CODE is not null and  to_char(EXT_ATTR_22,'YYYY-MM') = TO_CHAR( ? ,'YYYY-MM')
#sql = SELECT CODE FROM ORG_MEMBER WHERE CODE is not null and  to_char(EXT_ATTR_22,'YYYY-MM') = ?

sql1_name=五色清单应响应企业
sql1 = 

sql2_name=五色清单已响应企业
sql2=

OterUrl = jdbc:mysql://***********:3306?useSSL=false
OterUn = ****
OterPw = ****

a1_name=主表问题应回答数
a1=

a2_name=主表问题实际回答数
a2=

a3_name=主表问题实际关闭数
a3=

a4_name=子表问题应回答数
a4=

a5_name=子表问题已回答数
a5=

a6_name=子表问题满意度回复基数（分母）
a6=

a7_name=子表问题满意度回复满意数（分子）
a7=

b1_name=本月填报家数
b1=


b2_name=应填报企业数
b2=

b3_name=上期发货金额
b3=

b4_name=本年累计金额
b4=

b5_name=本月累计金额
b5= 

b6_name=本期发货金额
b6=

#quarter的值 LinkedHashMap
qtMap = {"10":"2019年整理情况","20":"2020年第一季度","30":"2020年第二季度","40":"2020年第三季度"}


