

// imports later

// implement the on ItemSelectedListener for the ArrayAdapter of the spinners
class StartGameDialogFragment : DialogFragment(), AdapterView.OnItemSelectedListener {

    // binding object for custom R.LayoutDialog 
    private lateinit val binding : DialogStartGameCustomBinding 
    private lateinit val gameFormatAdapter : ArrayAdapter
    private lateinit val opponentHeroAdapter : ArrayAdapter
    private lateinit val playerHeroAdapter : ArrayAdapter

    private var _gameFormat : String
    private var _opponenHero : Int
    private var _playerHero : Int

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            // get layout inflater to inflate the custom view for the dialog
            val inflater = requireActivity().layoutInflator;

            // here get the binding (view of the custom view for the dialog)
            binding = DialogStartGameCustomBinding.inflate (inflater)
            
            // the binding will have six views three textviews and thre spinners
            // I will need thre listview adapter

            setUpSpinnerAdapter()
            binding.spinnerGameFormat.adapter = gameFormatAdapter
            binding.spinnerOpponentHero.adapter = opponentHeroAdapter
            binding.spinnerPlayerHero.adapter = playerHeroAdapter

            builder
            .setView(binding.root, null) // pass here the custom view with binding.root
            .setMessage(R.string.dialog_start_game)
            .setPositiveButton(R.string.start,
                            DialogInterface.OnClickListener { dialog, id ->
                                // START THE GAME!
                                // use the navgraph to navigate to the GameFragment 
                                // pass arguments with safe Args 

                            })
            .setNegativeButton(R.string.cancel,
                            DialogInterface.OnClickListener { dialog, id ->
                                // User cancelled the dialog
                            })
            // Create the AlertDialog object and return it
            builder.create()

            // so we create the dialog but the 
            // show method will be called due to the navigation throu navigation component

        } ?: throw IllegalStateException("Activity cannot be null")
    }

fun setUpSpinnerAdapter()
{
    gameFormatAdapter = ArrayAdapter.createFromResource(
        this,
        R.array.game_format,  // array of different formats
        android.R.layout.simple_spinner_item
        ).also { adapter ->
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    opponentHeroAdapter = ArrayAdapter.createFromResource(
        this,
        R.array.heros,  // array of hero names 
        android.R.layout.simple_spinner_item
        ).also { adapter ->
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    playerHeroAdapter =  ArrayAdapter.createFromResource(
        this,
        R.array.heros,  // array of hero names 
        android.R.layout.simple_spinner_item
        ).also { adapter ->
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
}


 override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        when (parent.id)
        {
            R.id.spinnerGameFormat -> 
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }


}