package com.common.shy.interviewmodule.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.shy.interviewmodule.R;


public class Cell extends AppCompatActivity {

    private CellView mCellView;
    private boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter_activity_cell);
        mCellView = findViewById(R.id.view);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                generation();
                if (start) {
                    mCellView.stop();
//                    button.setText("Start");
                    start = !start;
                } else {
                    mCellView.startPropagate();
//                    button.setText("Stop");
                    start = !start;
                }
            }
        });
    }

//    private void generation() {
//        List<CellView.CellBean> cellBeans = mCellView.getmData();
//        List<CellView.CellBean> aliveList = new ArrayList<>();
//        List<CellView.CellBean> deadList = new ArrayList<>();
//        for (int i = 0; i < cellBeans.size() ;i++) {
//            CellView.CellBean cellBean = cellBeans.get(i);
//            int aliveNum = 0;
//            if (cellBean.mCellX - 1 >= 0 && cellBean.mCellY - 1 >= 0) {//存在左上第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i - 71);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellY - 1 >= 0) {//存在上面第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i - 70);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellX + 1 < 70 && cellBean.mCellY - 1 >= 0) {//存在右上面第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i - 69);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellX - 1 >= 0) {//存在左边第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i - 1);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellX + 1 < 70) {//存在右边第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i + 1);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellX - 1 >= 0 && cellBean.mCellY + 1 < 70) {//存在左下第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i + 69);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellY + 1 < 70) {//存在下面第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i + 70);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (cellBean.mCellX + 1 < 70 && cellBean.mCellY + 1 < 70) {//存在左下面第一个
//                CellView.CellBean cellBean1 = cellBeans.get(i + 71);
//                if (cellBean1.mAlive) {
//                    aliveNum++;
//                }
//            }
//            if (aliveNum == 3) {
//                aliveList.add(cellBean);
//            } else if (aliveNum == 2) {
//
//            } else {
//                deadList.add(cellBean);
//            }
//        }
//        for (CellView.CellBean cb : aliveList) {
//            cb.mAlive = true;
//        }
//        for (CellView.CellBean cb : deadList) {
//            cb.mAlive = false;
//        }
//        mCellView.invalidate();
//    }
}
