package tuanminh.nguyen.ui.dashboard;
//Tuan Minh Nguyen N01250520
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is N01250520 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}