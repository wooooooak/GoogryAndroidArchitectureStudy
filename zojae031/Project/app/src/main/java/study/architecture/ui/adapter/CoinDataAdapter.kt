package study.architecture.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import study.architecture.R
import study.architecture.model.vo.ProcessingTicker

/**
 * RecyclerView에 아이템을 뿌려주는 Adpater
 */
class CoinDataAdapter : RecyclerView.Adapter<CoinDataAdapter.Holder>() {

    private val lists: MutableList<ProcessingTicker> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))


    override fun getItemCount(): Int = lists.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    fun updateList(list: List<ProcessingTicker>) {
        lists.apply {
            clear()
            addAll(list)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val tradePrice: TextView = itemView.findViewById(R.id.trade_price)
        private val changeRate: TextView = itemView.findViewById(R.id.change_rate)
        private val accTradePrice24h: TextView = itemView.findViewById(R.id.acc_trade_price)

        fun bind(position: Int) {
            name.text = lists[position].market
            tradePrice.text = lists[position].tradePrice
            if (lists[position].changeRate[0] == '-') {
                changeRate.setTextColor(Color.RED)
            } else {
                changeRate.setTextColor(Color.BLUE)
            }
            changeRate.text = lists[position].changeRate
            accTradePrice24h.text = lists[position].accTradePrice24h
        }

    }
}