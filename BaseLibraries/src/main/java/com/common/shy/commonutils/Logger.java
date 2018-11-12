package com.common.shy.commonutils;


public class Logger {
	/**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;
    
	private Logger() {
		
    }
	
    // 是否打印Log(设置返回false则不打印Log)
    private static boolean isLogOn(){
        return BuildConfig.DEBUG;
    }

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int v(String tag, String msg) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
    	    tag = "";
    	}
    	if(msg == null){
    	    msg = "";
    	}
        return android.util.Log.v(tag, msg);
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static int v(String tag, String msg, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.v(tag, msg, tr);
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int d(String tag, String msg) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.d(tag, msg);
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static int d(String tag, String msg, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.d(tag, msg, tr);
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int i(String tag, String msg) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.i(tag, msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static int i(String tag, String msg, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.i(tag, msg, tr);
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int w(String tag, String msg) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.w(tag, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static int w(String tag, String msg, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.w(tag, msg, tr);
    }

    /*
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static int w(String tag, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
        return android.util.Log.w(tag, tr);
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int e(String tag, String msg) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.e(tag, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static int e(String tag, String msg, Throwable tr) {
    	if(!isLogOn()){
    		return 0;
    	}
    	if(tag == null){
            tag = "";
        }
    	if(msg == null){
            msg = "";
        }
        return android.util.Log.e(tag, msg, tr);
    }
}
