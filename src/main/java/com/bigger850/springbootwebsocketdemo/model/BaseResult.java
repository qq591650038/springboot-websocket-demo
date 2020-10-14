package com.bigger850.springbootwebsocketdemo.model;

public class BaseResult<T> {
	public static final long CODE_SUCCESS = 0;
    public static final long CODE_FAIL = -1;
    public static final long CODE_TIMEOUT = -2;
    public static final long CODE_EXCEPTION = 1;

    private Long code;
    private String msg;
    private T data;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

    public BaseResult(Long code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(T data) {
        super();
        this.code = 0L;
        this.data = data;
    }
    public BaseResult(){

    }

}
