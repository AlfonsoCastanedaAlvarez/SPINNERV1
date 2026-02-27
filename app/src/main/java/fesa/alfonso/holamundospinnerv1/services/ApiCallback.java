package fesa.alfonso.holamundospinnerv1.services;

public interface ApiCallback<T>{

    void onSuccess(T resolve);

    void onError(String error);
}
