package hk.edu.ouhk.arprimary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class LessonActivity extends AppCompatActivity {

    private static final String TAG = LessonActivity.class.getSimpleName();


    String topic;
    int unitNo;

    ArFragment arFragment;


    ModelRenderable apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        topic = getIntent().getExtras().getString("topic");
        unitNo = getIntent().getExtras().getInt("unit-no");

        //if (!isSupported(this)) return;

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.lesson_arfragment);

        if (arFragment == null) {
            Toast.makeText(this, "ArFragment is null", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        ModelRenderable.builder()
                .setSource(this, R.raw.apple)
                .build()
                .thenAcceptAsync(modelRenderable -> apple = modelRenderable)
        .exceptionally(ex -> {
            Toast.makeText(arFragment.getContext(), "Error:" + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        });



        arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    Anchor anchor = hitResult.createAnchor();
                    addNodeToScene(arFragment, anchor, apple);
                });
    }

    private void addNodeToScene(ArFragment arFragment, Anchor anchor, Renderable renderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setRenderable(renderable);
        node.setParent(anchorNode);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        node.select();
    }

    public static boolean isSupported(final Activity activity) {
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < 3.0) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }
}