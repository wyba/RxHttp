# RxHttp

    allprojects {
            repositories {
                ...
                maven { url 'https://jitpack.io' }
            }
        }
        
        
        dependencies {
        	        implementation 'com.github.wyba:RxHttp:V1.0.0'
        	}
        	

   Application:

         RxHttp.getInstance().init("http://192.168.2.112:8081/", 20 * 1000);

   Use:
          RxHttp.getInstance().get("book/framebookquery", bookRequest).execute(new CommonCallBack<BookResponse>() {
                     @Override
                     public void onFinal(BookResponse bookResponse) {
                         if (bookResponse != null) {
                             for (BookInfo bookInfo : bookResponse.getData_list()) {
                                 Log.e("queryShelfBook", "\n" + bookInfo.toString());
                             }
                         }
                     }
                 });

