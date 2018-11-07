package bg.o.sim.noterizmus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bg.o.sim.noterizmus.networking.backendService
import bg.o.sim.noterizmus.persistance.Note
import kotlinx.android.synthetic.main.fragment_new_note.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 *
 */
class NewNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.setText("TITLE TEST")
        content.setText("CONTENT TEST")

        button_send.setOnClickListener {
            backendService.saveNote(Note(title.text.toString(), content.text.toString())).enqueue(
                object : Callback<Note> {
                    override fun onFailure(call: Call<Note>, t: Throwable) {
                        title2.setText("Fuck :/")
                        content2.setText(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<Note>, response: Response<Note>) {
                        title2.setText(response.body()?.title)
                        content2.setText(response.body()?.content)
                    }
                }
            )

        }
    }

}
