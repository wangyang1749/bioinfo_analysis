import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
public class Test  {
    public static void main(String args[]) throws Exception{
        //System.out.println("1749748955");
         //建立连接
        RConnection rc=new RConnection();
        //构建数据
        int[] datas={314,451,56,24,631};
        //声明变量，相当于在R命令行中输入data<-datas命令
        rc.assign("data",datas);
        //执行R语句，相当于在R命令行中输max(data)命令
        REXP rexp=rc.eval("max(data)");
        //REXP. asXxx()返回相应类型的数据，如果结果类型不符会出错
        System.out.println(rexp.asInteger());

        REXP xp = rc.parseAndEval("try(png(filename = 'test.png'));");
            
        // if (xp.inherits("try-error")) { // if the result is of the class try-error then there was a problem
        //     System.err.println("Can't open png graphics device:\n"+xp.asString());
        //     // this is analogous to 'warnings', but for us it's sufficient to get just the 1st warning
        //     REXP w = rc.eval("if (exists('last.warning') && length(last.warning)>0) names(last.warning)[1] else 0");
        //     if (w.isString()) System.err.println(w.asString());
        //     return;
        // }
                 
        // ok, so the device should be fine - let's plot - replace this by any plotting code you desire ...
        rc.parseAndEval("plot(c(0)); dev.off()");
        
        // There is no I/O API in REngine because it's actually more efficient to use R for this
        // we limit the file size to 1MB which should be sufficient and we delete the file as well
        // xp = rc.parseAndEval("r=readBin('test.jpg','raw',1024*1024); unlink('test.jpg'); r");
			
        rc.close();
    }

}