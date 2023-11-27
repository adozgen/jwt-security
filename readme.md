### Spring Security nasıl uygulandığı ile ilgili demo

Jwt

1-Bir JWT, üç ana bölümden oluşur: Başlık (Header), Yük (Payload) ve İmza (Signature).

2-Stateless kimlik doğrulama sağlar.

3-Esneklik ve Platformlar Arası Uyumluluk vs gibi özellikler sağlar.

Spring Security 3 ana başlıkta toplanabilir.

### Configurasyon Tanımlamaları

SecurityConfiguration: Burada hangi endpoinlerde doğrulama mekanizmasını uygulamak istediğimizi ayarladık.

### Jwt ile ilgili işlemler

JwtService: Burada token ile ilgili işlemlerimizi topladık. Token oluşturma, claimsden token çıkarma vs.

### Filter

JwtAuthenticationFilter: Gelen requestin karşılandığı sınıf burada ui tarafından gönderilen istek incelenir.

Requestin header bilgisinde token olup/olmadığı durumuna göre işlemleri barındırır. Laraveldeki middleware karşılık gelmektedir.

Endpointler: 

    1-api/v1/auth/register

    /api/v1/auth/** whitelistimizde olduğu için security bu endpoint için doğrulama yapmayacaktır.

![register.png](src%2Fmain%2Fresources%2Fstatic%2Fregister.png)

    2-/api/v1/dashboard/index 
    
    Burada önceki istekte oluşturduğumuz token bilgisini göndererek erişim sağlayabiliriz.


![dashboard.png](src%2Fmain%2Fresources%2Fstatic%2Fdashboard.png)
