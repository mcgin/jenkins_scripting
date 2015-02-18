Basic class to do a HTTP get on a URL and return the output.  Uses no external dependencies.

    import javax.net.ssl.HostnameVerifier
    import javax.net.ssl.HttpsURLConnection
    import javax.net.ssl.SSLContext
    import javax.net.ssl.TrustManager
    import javax.net.ssl.X509TrustManager
     
    class HttpClient {
      def get(url) {
        def maxRetries = 3
        def i = 0
        def _responseCode
        def _content
        while (i++ < maxRetries) {
          try {
            (_content, _responseCode) = url.toURL().openConnection().with { conn ->
              readTimeout = 3000
              [conn.content.withReader { r -> r.text }, responseCode]
            }
          } catch (e) {
            context.println e
          }
          if (_responseCode == 200) {
            return _content
          }
          context.println "GET ${url}, reponseCode: ${responseCode}. Retrying in ${i*i} seconds"
          sleep(i * i * 1000)
        }
        throw new IOException("Timed out trying to GET ${url}")
      }
      def disableSSLCertVerification() {
        def nullTrustManager = [
          checkClientTrusted: { chain, authType ->  },
          checkServerTrusted: { chain, authType ->  },
          getAcceptedIssuers: { null }
        ]
        def nullHostnameVerifier = [
          verify: { hostname, session -> true }
        ]
        SSLContext sc = SSLContext.getInstance("SSL")
        sc.init(null, [nullTrustManager as X509TrustManager] as TrustManager[], null)
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory())
        HttpsURLConnection.setDefaultHostnameVerifier(nullHostnameVerifier as HostnameVerifier)
      }
    }
     
