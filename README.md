# RxHttp

    allprojects {
            repositories {
                ...
                maven { url 'https://jitpack.io' }
            }
        }
        
        
        dependencies {
        	        implementation 'com.github.wyba:RxHttp:V1.0.3'
        	}
        	

   Application:

        RxHttp.init("http://192.168.2.112:8081/", 20 * 1000);

   Use:

        RxHttp.post(url, content, new CommonCallBack<String>() {
                          @Override
                          public void onFinal(String s) {
                              
                          }
                      });

