package ken.mx.spotifyplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ken.mx.spotifyplayer.models.Track;
import ken.mx.spotifyplayer.models.spotify.Image;
import ken.mx.spotifyplayer.models.spotify.Item;

/**
 * Created by Ken on 04/10/16.
 */

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private List<Item> trackList;
    private Context context;
    private MediaPlayer mediaPlayer;

    public TrackAdapter(List<Item> trackList, Context context) {
        this.trackList = trackList;
        this.context = context;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        Item itemTrack = trackList.get(position);
        holder.bindTrack(itemTrack);
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTrack;
        private TextView tvTrackName;
        private ImageView imgPlay;

        public TrackViewHolder(View itemView) {
            super(itemView);

            imgTrack = (ImageView) itemView.findViewById(R.id.item_image_track);
            tvTrackName = (TextView) itemView.findViewById(R.id.item_tv_track_name);
            imgPlay = (ImageView) itemView.findViewById(R.id.item_play);
        }

        public void bindTrack(final Item itemTrack) {

            tvTrackName.setText(itemTrack.getName());

            List<Image> images = itemTrack.getAlbum().getImages();
            if (images.size() > 0) {
                String imageUrl = images.get(0).getUrl();
                Glide.with(context).load(imageUrl).into(imgTrack);
            }


            imgPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mediaPlayer == null) {
                        mediaPlayer = new MediaPlayer();
                    }

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }

                    try {
                        mediaPlayer.setDataSource(itemTrack.getPreviewUrl());
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

        }
    }

}
