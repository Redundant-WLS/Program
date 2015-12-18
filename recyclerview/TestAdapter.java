
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText("" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"item click",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 500;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        EditText title;
        MyViewHolder(View view) {
            super(view);
            this.title=(EditText)view.findViewById(R.id.title);
        }

    }
}
