package app.zd.myredpackage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import app.zd.myredpackage.bean.RedPackageParam;
import app.zd.myredpackage.utils.DialogUtilLib;
import app.zd.myredpackage.utils.NumberUtil;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText mPriceEt;
    private EditText mCountEt;
    private EditText mDescribeEt;
    private TextView mShowPriceTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPriceEt = (EditText) findViewById(R.id.et_price);
        mCountEt = (EditText) findViewById(R.id.et_count);
        mDescribeEt = (EditText) findViewById(R.id.et_describe);
        mShowPriceTv = (TextView) findViewById(R.id.tv_show_price);
        findViewById(R.id.btn_input_red_package).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_input_red_package:
                String priceString = mPriceEt.getText().toString();
                String countString = mCountEt.getText().toString();
                String describe = mDescribeEt.getText().toString();
                if (judgePriceAndCount(NumberUtil.stringToInteger(priceString),
                        NumberUtil.stringToInteger(countString))) {
                    RedPackageParam packageParam = new RedPackageParam();
                    packageParam.amount = new BigDecimal(priceString);
                    packageParam.number = new BigDecimal(countString);
                    packageParam.describe = TextUtils.isEmpty(describe) ?
                            getString(R.string.default_leave_message_hint) : describe;
                    Intent intent = new Intent(this, RedPackageListActivity.class);
                    intent.putExtra(GlobalConstant.IntentConstant.RED_PACKAGE_PARAM, packageParam);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    private boolean judgePriceAndCount(int price, int count) {
        if (price <= 0) {
            DialogUtilLib.showShortPromptToast(this, getString(R.string.red_package_price_tip));
            return false;
        }
        if (count <= 0) {
            DialogUtilLib.showShortPromptToast(this, getString(R.string.red_package_number_tip));
            return false;
        }
        return true;
    }
}
