package ac.mz.gestaodeinformacao;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.io.Serializable;

public class ArrayAdapterWrapper<T> implements Parcelable {
    private ArrayAdapter<T> adapter;



    public ArrayAdapter<T> getAdapter() {
        return adapter;
    }

    // Implemente os métodos necessários da interface Parcelable
    // Aqui está um exemplo simplificado para o método writeToParcel:
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable((Serializable) adapter);
    }

    // Aqui está um exemplo simplificado para o método CREATOR:
    public static final Parcelable.Creator<ArrayAdapterWrapper> CREATOR = new Parcelable.Creator<ArrayAdapterWrapper>() {
        public ArrayAdapterWrapper createFromParcel(Parcel in) {
            return new ArrayAdapterWrapper(in);
        }

        public ArrayAdapterWrapper[] newArray(int size) {
            return new ArrayAdapterWrapper[size];
        }
    };

    protected ArrayAdapterWrapper(Parcel in) {
        adapter = (ArrayAdapter<T>) in.readSerializable();
    }

    @Override
    public int describeContents() {
        return 0;
    }


}


