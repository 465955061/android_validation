package com.jifeng.compant;

import java.util.ArrayList;
import java.util.List;
import com.example.android_validation.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class VEditText extends EditText implements
		android.view.View.OnFocusChangeListener {
	List<String> ISERROR = new ArrayList<String>();
	TypedArray typedArray;
	String regex;
	String regexrule;
	boolean require;
	float maxvalue = -1;
	float minvalue = -1;
	int decimal = 0;

	public VEditText(Context context) {
		this(context, null);
		init(context, null);
		ISERROR = new ArrayList<String>();
	}

	public VEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
		ISERROR = new ArrayList<String>();

	}

	public VEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
		ISERROR = new ArrayList<String>();

	}

	public void init(Context context, AttributeSet attrs) {

		typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.Vedittext);
		regex = typedArray.getString(R.styleable.Vedittext_regex);
		if (regex != null && !regex.isEmpty() && regex != "") {
			regexrule = typedArray.getString(R.styleable.Vedittext_regexrule);
		}
		require = typedArray.getBoolean(R.styleable.Vedittext_require, false);
		if (this.getInputType() == android.text.InputType.TYPE_CLASS_NUMBER) {
			maxvalue = typedArray.getFloat(R.styleable.Vedittext_maxvalue, -1);
			minvalue = typedArray.getFloat(R.styleable.Vedittext_minvalue, -1);
			decimal = typedArray.getInt(R.styleable.Vedittext_decimal, 0);
		}
		this.setOnFocusChangeListener(this);

		try {

			if (ISERROR == null) {
				ISERROR = new ArrayList<String>();
			} else {
				ISERROR.clear();
			}

			if (require) {

				if (getText().toString().equals("")) {
					ISERROR.add("输入内容不能为空");

				}

			}
			if (!getText().toString().equals("")
					&& this.getInputType() == android.text.InputType.TYPE_CLASS_NUMBER) {
				float result = Float.parseFloat(getText().toString());
				if (maxvalue != -1 && minvalue != -1) {

					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					} else if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				} else if (maxvalue != -1) {
					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					}
				} else if (minvalue != -1) {
					if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				}
				if (decimal > 0) {
					setText(String.format("%." + decimal + "f", getText()
							.toString()));
				}

			}

			if (regex != null && !regex.isEmpty() && regex != "") {
				if (!getText().toString().matches(regex)) {
					if (regexrule != null && !regexrule.isEmpty()
							&& regexrule != "") {
						ISERROR.add(regexrule);
					} else {
						ISERROR.add("输入内容不符合");
					}
				}
			}

			if (ISERROR.size() > 0) {
				this.setError(ISERROR.get(0));
			} else {
				this.setError(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// this.addTextChangedListener(this);
	}

	public List<String> getISERROR() {
		return ISERROR;
	}

	public void setISERROR(List<String> iSERROR) {
		ISERROR = iSERROR;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub

		try {

			if (ISERROR == null) {
				ISERROR = new ArrayList<String>();
			} else {
				ISERROR.clear();
			}

			if (require) {
				if (getText().toString().equals("")) {
					ISERROR.add("输入内容不能为空");

				}

			}
			if (!getText().toString().equals("")
					&& this.getInputType() == android.text.InputType.TYPE_CLASS_NUMBER) {
				float result = Float.parseFloat(getText().toString());
				if (maxvalue != -1 && minvalue != -1) {

					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					} else if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				} else if (maxvalue != -1) {
					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					}
				} else if (minvalue != -1) {
					if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				}
				if (decimal > 0) {
					setText(String.format("%." + decimal + "f", getText()
							.toString()));
				}

			}

			if (regex != null && !regex.isEmpty() && regex != "") {
				if (!getText().toString().matches(regex)) {
					if (regexrule != null && !regexrule.isEmpty()
							&& regexrule != "") {
						ISERROR.add(regexrule);
					} else {
						ISERROR.add("输入内容不符合");
					}
				}
			}

			if (ISERROR.size() > 0) {
				this.setError(ISERROR.get(0));
			} else {
				this.setError(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		// TODO Auto-generated method stub
		// super.onTextChanged(text, start, lengthBefore, lengthAfter);
		Log.i("ontextchanged", "lengthbefore=" + lengthBefore + "; start="
				+ start + "; length=" + lengthAfter + "text=" + text);
		try {

			if (ISERROR == null) {
				ISERROR = new ArrayList<String>();
			} else {
				ISERROR.clear();
			}

			if (require) {
				if (lengthBefore == 1 && start == 0) {
					setText("");
					ISERROR.add("输入内容不能为空");
				}
				if (getText().toString().equals("")) {
					ISERROR.add("输入内容不能为空");

				}

			}
			if (!getText().toString().equals("")
					&& this.getInputType() == android.text.InputType.TYPE_CLASS_NUMBER) {
				float result = Float.parseFloat(getText().toString());
				if (maxvalue != -1 && minvalue != -1) {

					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					} else if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				} else if (maxvalue != -1) {
					if (result > maxvalue) {
						ISERROR.add("不能超过" + maxvalue);
					}
				} else if (minvalue != -1) {
					if (result < minvalue) {
						ISERROR.add("不能小于" + minvalue);
					}
				}
				if (decimal > 0) {
					setText(String.format("%." + decimal + "f", getText()
							.toString()));
				}

			}

			if (regex != null && !regex.isEmpty() && regex != "") {
				if (!getText().toString().matches(regex)) {
					if (regexrule != null && !regexrule.isEmpty()
							&& regexrule != "") {
						ISERROR.add(regexrule);
					} else {
						ISERROR.add("输入内容不符合");
					}
				}
			}

			if (ISERROR.size() > 0) {
				this.setError(ISERROR.get(0));
			} else {
				this.setError(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (require) {
			ISERROR.clear();

			if (keyCode == KeyEvent.KEYCODE_DEL
					&& (this.getText().toString().equals("") || getText()
							.length() == 0)) {

				ISERROR.add("输入内容不能为空");
				this.setError(ISERROR.get(0));
				ISERROR.clear();
				return false;
			}

		}
		return super.onKeyDown(keyCode, event);
	}

}
