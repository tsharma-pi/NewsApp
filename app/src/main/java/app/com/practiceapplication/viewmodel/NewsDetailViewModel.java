package app.com.practiceapplication.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsDetailViewModel extends BaseObservable
{
  private String url;

  public NewsDetailViewModel(String url) {
    this.url = url;
  }
  public String getUrl(){return this.url;}

  @BindingAdapter({ "app:setWebViewClient" })
  public static void setWebViewClient(WebView view, WebViewClient client) {
    view.setWebViewClient(client);
  }

  @BindingAdapter({ "app:loadUrl" })
  public static void loadUrl(WebView view, String url) {
    view.loadUrl(url);
  }
  private class Client extends WebViewClient {
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request,
        WebResourceError error) {
      super.onReceivedError(view, request, error);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
      super.onPageFinished(view, url);
    }
  }

  public WebViewClient getWebViewClient() {
    return new Client();
  }


}