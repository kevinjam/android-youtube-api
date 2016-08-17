package com.kevinjanvier.youtubeapikevin.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.kevinjanvier.youtubeapikevin.R;
import com.kevinjanvier.youtubeapikevin.content.VideoListAdapter;
import com.kevinjanvier.youtubeapikevin.content.YouTubeContent;

/**
 * Created by kevinjanvier on 17/08/16.
 */
public class VideoListFragment extends ListFragment {

    /**
     * Empty constructor
     */
    public VideoListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new VideoListAdapter(getActivity()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        final Context context = getActivity();
        final String DEVELOPER_KEY = getString(R.string.DEVELOPER_KEY);
        final YouTubeContent.YouTubeVideo video = YouTubeContent.ITEMS.get(position);

        switch (position) {
            case 0:
                //Check whether we can actually open YT
                if (YouTubeIntents.canResolvePlayVideoIntent(context)) {
                    /**
                     * Open inside a Dialog Box
                     */
                startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                        DEVELOPER_KEY, video.id, 0, true, true));
                }
                break;
            case 1:
                if (YouTubeIntents.canResolvePlayVideoIntentWithOptions(context)) {
                    //Opens in the YouTube app in fullscreen and returns to this app once the video finishes
                    startActivity(YouTubeIntents.createPlayVideoIntentWithOptions(context, video.id, true, true));
                }
                break;
            case 2:
                //Issue #3 - Need to resolve StandalonePlayer as well
                if (YouTubeIntents.canResolvePlayVideoIntent(context)) {
                    //Opens in the StandAlonePlayer, defaults to fullscreen
                    startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                            DEVELOPER_KEY, video.id));
                }
                break;
            case 3:
                //Issue #3 - Need to resolve StandalonePlayer as well
                if (YouTubeIntents.canResolvePlayVideoIntentWithOptions(context)) {
                    //Opens in the StandAlonePlayer but in "Light box" mode
                    startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                            DEVELOPER_KEY, video.id, 0, true, true));
                }
                break;


        }
    }

}
