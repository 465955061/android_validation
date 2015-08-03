# android_validation
edittext验证

开发者可以直接调用VEditText这个类。此类已经继承EditText

activity为了 增加控件的验证在VActivity中我增加了验证的方法以及加入控件的方法


在activity 初始化中 调用addList(VEditText vedittext)这个方法 将所有控件加入到list中


在提交的事件中调用fromvalidate()  此方法返回boolean  如果为true 表示验证成功  flase 验证失败  
