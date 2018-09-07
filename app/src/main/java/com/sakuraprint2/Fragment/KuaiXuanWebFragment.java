package com.sakuraprint2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sakuraprint2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * com.sakuraprint2
 *
 * @author 赵磊
 * @date 2018/7/21
 * 功能描述：
 */
public class KuaiXuanWebFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.web)
    WebView webview;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuaixuan_web, container, false);
        unbinder = ButterKnife.bind(this, view);
        //加载assets目录下的html
        //加上下面这段代码可以使网页中的链接不以浏览器的方式打开
        webview.setWebViewClient(new WebViewClient());
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);//滚动条风格，为0指滚动条不占用空间，直接覆盖在网页上
        //得到webview设置
        WebSettings webSettings = webview.getSettings();
        //允许使用javascript
        webSettings.setJavaScriptEnabled(true);
        //设置字符编码
        webSettings.setDefaultTextEncodingName("UTF-8");
        //支持缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        //将WebAppInterface与javascript绑定
        //webview.addJavascriptInterface(new PaymentJavaScriptInterface(),"Android");
        //android assets目录下html文件路径url为 file:///android_asset/profile.html
        String url = "file:///android_asset/" + "soonselect.html";
        webview.loadUrl(url);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }
    }
}