package com.yhw.wan.coreapp.main.setting;

import com.yhw.wan.core.basemvp.BaseModel;
import com.yhw.wan.core.basemvp.BasePresenter;
import com.yhw.wan.core.basemvp.BaseView;
import com.yhw.wan.ui.recycler.MultipleItemEntity;

import java.util.List;

/**
 * Created by BYDeXL on 2018/1/9.
 */

public interface SettingContract {

    interface SettingModel extends BaseModel {
        void loadDaily(String url);
    }

    interface SettingView extends BaseView {
        void setData(List<MultipleItemEntity> beanList);
    }

    abstract class SettingPresenter extends BasePresenter<SettingModel, SettingView> {
        protected abstract void loadData(String url);

        protected abstract void loadData2(String url);
    }

}
