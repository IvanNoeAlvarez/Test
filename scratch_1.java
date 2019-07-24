import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Clase de utilidad para usar Glide.
 * NOTA: para tener Glide en el proyecto usar en el archivo build.gradle del modulo:
 * implementation 'com.github.bumptech.glide:glide:4.8.0'
 * annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
 * Recuerda que las versiones puedes estar desactualizadas
 */
class UtilsGlide extends AppGlideModule {


    /**
     * Usa la libreria de glide para cargar URLs en ImageViews
     *
     * @param url  URL de la imagen a usar
     * @param view View en la cual cargar la imagen
     */
    public static void glideUrlIntoDrawable(String url, @NonNull ImageView view) {
        try {
            String urlAux = "https://icon-library.net//images/error-image-icon/error-image-icon-18.jpg";
            Glide
                    .with(view.getContext())
                    .load(url)
                    .error(errorGlide(view.getContext(), urlAux))
                    .into(view);
        } catch (Exception ignored) {
        }
    }

    public static Drawable glideGetBitmap(Context c, String url) {
        final Drawable[] ret = {null};
        View v = new View(c);
        Glide.with(c).load(url).into(new CustomViewTarget<View, Drawable>(v) {
            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
            }

            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                ret[0] = resource;
            }

            @Override
            protected void onResourceCleared(@Nullable Drawable placeholder) {
            }
        });
        return ret[0];
    }


    /**
     * Metodo de utilidad para cargar una imagen por defecto
     */
    private static RequestBuilder<Drawable> errorGlide(Context c, String url) {
        Log.e("UtilsImages#errorGlide", "Error con la url: " + url);
        return Glide.with(c).load(url);
    }
}