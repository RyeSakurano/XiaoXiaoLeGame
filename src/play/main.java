package play;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
 
import constant.Mycolor;
import exception.NearCellException;
import exception.NoSpoilageException;
import model.RemoveScaleResult;
import exception.Addiction;

public class main {/*
	public static void main(String [] args) throws IOException, InterruptedException {
		Addiction.init();
		while (true) {
			Addiction.rest(Addiction.judgeRest());
			BasePlay xiao = new BasePlay(10, 10);
			if (Addiction.judgePlay())
				Addiction.rest(Addiction.PLAY);
		}
	}*/
	public static void main(String [] args) throws IOException, InterruptedException {
		BasePlay xiao = new BasePlay(10, 10);
	}
}
