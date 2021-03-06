package concept.learnnio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class Watcher {

	public static void main(String[] args) {
        Path this_dir = Paths.get(".");
        System.out.println("Now watching the current directory ...");  
        System.out.println(this_dir.toAbsolutePath().toString());
        try {
            WatchService watcher = this_dir.getFileSystem().newWatchService();
            this_dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
 
            WatchKey watckKey = watcher.take();
 
            List<WatchEvent<?>> events = watckKey.pollEvents();
            for (WatchEvent<?> event : events) {
                //System.out.println("Someone just created the file '" + event.context().toString() + "'.");
            	if(event.kind() == StandardWatchEventKinds.ENTRY_CREATE){
            		System.out.println("Created: " + event.context().toString());
            	}else if(event.kind() == StandardWatchEventKinds.ENTRY_DELETE){
            		System.out.println("Delete: " + event.context().toString());
            	}else if(event.kind() == StandardWatchEventKinds.ENTRY_MODIFY){
            		System.out.println("Modify: " + event.context().toString());
            	}
            	
            	System.out.println("Some update occured in file :"+event.context().toString());
            }
 
       } catch (Exception e) {
           System.out.println("Error: " + e.toString());
       }
    }
}
