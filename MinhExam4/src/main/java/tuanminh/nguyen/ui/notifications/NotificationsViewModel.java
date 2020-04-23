package tuanminh.nguyen.ui.notifications;
//Tuan Minh Nguyen N01250520
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is Nguyen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}