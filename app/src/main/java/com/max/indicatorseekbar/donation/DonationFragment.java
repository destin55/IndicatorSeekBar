package com.max.indicatorseekbar.donation;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.max.indicatorseekbar.R;
import com.max.indicatorseekbar.fragment.BaseFragment;


/**
 * the Fragment for donation, no impact libs
 */

public class DonationFragment extends BaseFragment implements View.OnClickListener {

    private View mAlipayQRCode;
    private View mWechatpayQRCode;

    @Override
    protected int getLayoutId() {
        return R.layout.buy_me_a_coffee;
    }

    @Override
    protected void initView(View root) {
        root.findViewById(R.id.alipay_text).setOnClickListener(this);
        root.findViewById(R.id.wechatpay_text).setOnClickListener(this);
        root.findViewById(R.id.paypal_text).setOnClickListener(this);
        mAlipayQRCode = root.findViewById(R.id.alipay_qr_code);
        mWechatpayQRCode = root.findViewById(R.id.wechatpay_qr_code);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.alipay_text){
            alipay();
        } else if (id == R.id.wechatpay_text){
            wechatPay();
        } else if (id == R.id.paypal_text){
            paypal();
        }
    }

    private void alipay() {
        if (AlipayUtil.hasInstalledAlipayClient(requireContext())) {
            AlipayUtil.startAlipayClient(requireActivity());
        } else {
            mAlipayQRCode.setVisibility(mAlipayQRCode.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    }

    private void wechatPay() {
        mWechatpayQRCode.setVisibility(mWechatpayQRCode.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    private void paypal() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.me/BuyMeACupOfTeaThx")));
    }

}
