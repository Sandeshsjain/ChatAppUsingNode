package com.example.chatappusingsocketio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatBoxAdapter extends RecyclerView.Adapter<ChatBoxAdapter.ChatViewHolder> {
    List<Message> list;
    Context context;

    public ChatBoxAdapter(List<Message> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.message.setText(list.get(position).getMessage());
        holder.nickname.setText(list.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView nickname,message;
        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.nickname);
            message = itemView.findViewById(R.id.message);
        }
    }
}
