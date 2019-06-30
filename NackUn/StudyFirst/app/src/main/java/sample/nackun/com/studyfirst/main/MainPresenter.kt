package sample.nackun.com.studyfirst.main

import sample.nackun.com.studyfirst.data.DataSource
import sample.nackun.com.studyfirst.data.Repository
import sample.nackun.com.studyfirst.util.TickerFormatter
import sample.nackun.com.studyfirst.vo.Ticker

class MainPresenter(
    val mainView: MainContract.View,
    val repository: Repository
) : MainContract.Presenter,
    DataSource.RequestTickersCallback {

    init {
        mainView.presenter = this
    }

    override fun requestTickers(marketName: String) =
        repository.requestMarkets(marketName, this)

    override fun onError(t: Throwable) =
        mainView.showMsg(t.message)

    override fun onTickersLoaded(tickers: List<Ticker>) =
        mainView.showTickers(TickerFormatter.convertTo(tickers))
}