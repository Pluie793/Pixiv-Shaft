package ceui.lisa.adapters;

import android.content.Context;
import android.widget.CompoundButton;

import java.util.List;

import ceui.lisa.R;
import ceui.lisa.databinding.RecySelectTagBinding;
import ceui.lisa.models.TagsBean;

public class SAdapter extends BaseAdapter<TagsBean, RecySelectTagBinding> {

    public SAdapter(List<TagsBean> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_select_tag;
    }

    @Override
    public void bindData(TagsBean target, ViewHolder<RecySelectTagBinding> bindView, int position) {
        bindView.baseBind.starSize.setText(allIllust.get(position).getName());
        bindView.baseBind.illustCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allIllust.get(position).setSelected(true);
                } else {
                    allIllust.get(position).setSelected(false);
                }
            }
        });
        if (allIllust.get(position).isSelected()) {
            bindView.baseBind.illustCount.setChecked(true);
        } else {
            bindView.baseBind.illustCount.setChecked(false);
        }
        if (mOnItemClickListener != null) {
            bindView.itemView.setOnClickListener(v -> bindView.baseBind.illustCount.performClick());
        }
    }
}
