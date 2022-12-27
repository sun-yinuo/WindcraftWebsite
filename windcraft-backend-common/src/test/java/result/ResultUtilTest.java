package result;

import junit.framework.TestCase;

public class ResultUtilTest extends TestCase {

    //NoData
    public void testResultERRORNoData() {System.err.println(ResultUtil.result(ResultEnum.SUCCESS.getCode(),"ERROR"));}
    public void testResultSUCCESSNoData() {System.err.println(ResultUtil.result(ResultEnum.SUCCESS.getCode(),"SUCCESS"));}

    //HaveData
    public void testResultSUCCESS() {System.out.println(ResultUtil.result(ResultEnum.SUCCESS.getCode(),"TEST==>SUCCESS{ResultUtil.result}","SUCCESS"));}
    public void testResultERROR() {System.out.println(ResultUtil.result(ResultEnum.SUCCESS.getCode(),"TEST==>ERROR{ResultUtil.result}","ERROR"));}

}