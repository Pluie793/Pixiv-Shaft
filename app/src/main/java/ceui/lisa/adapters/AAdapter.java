package ceui.lisa.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.R;
import ceui.lisa.databinding.RecyArticalBinding;
import ceui.lisa.databinding.RecyUserEventBinding;
import ceui.lisa.model.IllustsBean;
import ceui.lisa.model.SpotlightArticlesBean;
import ceui.lisa.utils.GlideUtil;

public class AAdapter extends BaseAdapter<SpotlightArticlesBean, RecyArticalBinding> {

    private int imageSize;

    public AAdapter(List<SpotlightArticlesBean> targetList, Context context) {
        super(targetList, context);
        imageSize = mContext.getResources().getDisplayMetrics().widthPixels -
                2 * mContext.getResources().getDimensionPixelSize(R.dimen.sixteen_dp);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_artical;
    }

    @Override
    public void bindData(SpotlightArticlesBean target, ViewHolder<RecyArticalBinding> bindView, int position) {
        ViewGroup.LayoutParams params = bindView.baseBind.illustImage.getLayoutParams();
        params.height = imageSize * 7 / 10;
        params.width = imageSize;
        bindView.baseBind.illustImage.setLayoutParams(params);
        bindView.baseBind.title.setText(target.getTitle());

        Glide.with(mContext).load(GlideUtil.getMediumImg(target.getThumbnail()))
                .into(bindView.baseBind.illustImage);
        if (mOnItemClickListener != null) {
            bindView.itemView.setOnClickListener(v ->
                    mOnItemClickListener.onItemClick(v, position, 0));
        }
    }
}
