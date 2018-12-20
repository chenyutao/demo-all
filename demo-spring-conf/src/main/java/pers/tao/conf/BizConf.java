package pers.tao.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *  支持 array,list,map,嵌套对象
 * @author chenyutao
 */
@Data
@Component
@ConfigurationProperties(prefix = "biz.config")
public class BizConf {
    private Integer integerProp;
    private String stringProp;
    private String[] arrayProps;
    private List<Map<String, String>> listProp1;
    private List<String> listProp2;
    private Map<String, String> mapProps;
    private Map<String, BizConfModel> mapProps2;

}
