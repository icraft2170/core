package hello.core.lifecycle;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url : " + url);
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message ="+ message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    // 의존관계 주입 이후 호출
    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메시");
    }

    // 해당 Bean이 종료될 때 호출
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
