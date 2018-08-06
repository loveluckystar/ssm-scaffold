package action;

import com.qunar.fuwu.orderapp.api.common.NationalParam;
import com.qunar.fuwu.orderapp.api.orderInfo.pojo.NationalOrderBaseInfo;
import com.qunar.fuwu.orderapp.api.orderInfo.service.IOrderDetailQueryService;
import com.qunar.fuwu.orderapp.api.orderInfo.service.IOrderInfoQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mxy on 2018/8/5.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Resource
    private IOrderInfoQueryService orderInfoQueryService;

    @RequestMapping("testDubbo")
    @ResponseBody
    public Object testDubbo(String orderNo,String domain){
        NationalOrderBaseInfo info = orderInfoQueryService.queryOrderBaseInfo(orderNo, new NationalParam(domain, "fuwu_gq"));
        System.out.println(info == null);
        if (info!=null){
            return info.getOrderId();
        }
        return "abc";
    }

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
    }
}
