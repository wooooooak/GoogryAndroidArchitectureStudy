package com.example.architecturestudy.data.source

import android.util.Log
import com.example.architecturestudy.data.CoinMarketResponse
import com.example.architecturestudy.data.CoinTickerResponse
import com.example.architecturestudy.data.source.local.CoinsLocalDataSource
import com.example.architecturestudy.data.source.remote.CoinsRemoteDataSource

object CoinsRepository : CoinsDataSource {
    private val coinsRemoteDataSource: CoinsRemoteDataSource = CoinsRemoteDataSource
    private val coinsLocalDataSource: CoinsLocalDataSource = CoinsLocalDataSource


    override fun getAllMarket(callback: CoinsDataSource.GetAllMarketCallback) {

        //현재는 remote하고만 연결해준다.
        coinsRemoteDataSource.getAllMarket(object : CoinsDataSource.GetAllMarketCallback {
            override fun onAllMarketLoaded(markets: List<CoinMarketResponse>) {
                callback.onAllMarketLoaded(markets)
            }

            override fun onDataNotAvailable() {
                Log.d("test", "getAllMarket data not available")
            }
        })

        //local로 데이터를 받아오는 기능이 생기면 추가 구현해야함.
    }

    override fun getCoinTickers(markets: String, callback: CoinsDataSource.GetCoinTickersCallback) {
        //현재는 remote하고만 연결해준다.
        coinsRemoteDataSource.getCoinTickers(markets, object : CoinsDataSource.GetCoinTickersCallback {
            override fun onTickersLoaded(tickers: List<CoinTickerResponse>) {
                callback.onTickersLoaded(tickers)
            }

            override fun onDataNotAvailable() {
                Log.d("test", "getCoinTickers data not available")
            }
        })


        //local로 데이터를 받아오는 기능이 생기면 추가 구현해야함.
    }

}