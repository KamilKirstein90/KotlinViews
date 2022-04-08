
/*use one onklick listener for diffrent views with 
when(view)
{
    button1 ->
    ,
    button2 -> 
    ,
}
    syntax
} */ 

class GameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    // Binding object instance with access to the views in the game_fragment.xml layout
    private lateinit var binding: GameFragmentBinding

    // this is a flag to don´t reshow the dialog when the game is already stared
    private lateinit var gameStarted : bool

    // Create a ViewModel the first time the fragment is created.
    // If the fragment is re-created, it receives the same GameViewModel instance created by the
    // first fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout XML file and return a binding object instance
        binding = GameFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get configuration from savedInstanceState if aviable



        // here we will have the views from the binding
        // 4 buttons for live add- and subtraction
        // 2 imageviews for the selected hero
        // 2 textviews "oponnent + hero name", "player + herro name"

        // before we start the game we first go to the StartGameDialogFragment to configurate 
        // the Settings for the GameFragment and pass them as args to 
        findNavController().navigate(R.id.action_GameFragment_to_StartGameDialog)
      
    }


}