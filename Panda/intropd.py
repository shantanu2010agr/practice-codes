import pandas as pd
a ='~/Downloads/TopSellingAlbums.csv'

df=pd.read_csv(a)

# print(df)
x=df.iloc[0,2]
print(x)
y=df[['Released','Soundtrack']]
print(y)