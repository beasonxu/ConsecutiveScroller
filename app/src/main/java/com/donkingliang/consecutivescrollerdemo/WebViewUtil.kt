@file:Suppress("DEPRECATION")

package com.donkingliang.consecutivescrollerdemo

import android.content.Context
import android.os.Build
import android.view.View
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * WebViewUtil
 */
object WebViewUtil {

    fun initSettings(webview: WebView) {
        val webSettings = webview.settings
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webSettings.domStorageEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webSettings.databaseEnabled = true
        val databasePath = webview.context.getDir("database", Context.MODE_PRIVATE).path
        webSettings.databasePath = databasePath
        webSettings.setGeolocationEnabled(true)
        webSettings.setGeolocationDatabasePath(databasePath)
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.setSupportZoom(false)
        webSettings.builtInZoomControls = false
        webSettings.displayZoomControls = false
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.pluginState = WebSettings.PluginState.ON_DEMAND
        webSettings.textZoom = 100
        val userAgent = "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/KRT16M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36"
        webSettings.userAgentString = userAgent
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.allowFileAccess = true
        webSettings.javaScriptEnabled = true
        webSettings.savePassword = false
        //         webSettings.setSupportZoom(support);
        webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY


        webview.requestFocus()
        webview.requestFocusFromTouch()
    }

    /**
     * Clear the browser's cookie cache
     * @param context
     */
    fun clearWebCache(context: Context) {
        CookieSyncManager.createInstance(context)
        val cm = CookieManager.getInstance()
        cm.removeSessionCookie()
        cm.removeAllCookie()
        CookieSyncManager.getInstance().startSync()
    }

    /**
     * Sync cookies
     */
    fun synCookies(context: Context, url: String, cookies: String) {
        CookieSyncManager.createInstance(context)
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.removeSessionCookie()
        cookieManager.setCookie(url, cookies)
        CookieSyncManager.getInstance().sync()
    }
}
