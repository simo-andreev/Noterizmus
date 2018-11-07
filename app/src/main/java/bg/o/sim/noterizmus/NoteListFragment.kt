package bg.o.sim.noterizmus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_note_list.*

/**
 * A simple [Fragment] subclass.
 * TODO
 */
class NoteListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        new_note_fab.setOnClickListener {
            view.findNavController().navigate(R.id.action_noteListFragment_to_newNoteFragment)
        }

        note_list.adapter = NoteListAdapter()
    }


    private class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        private class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}
