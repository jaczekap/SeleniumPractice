
Call("setPath", $CmdLine[1])
Sleep(500)

Func setPath($path)
	Sleep(500)
	ControlFocus("Otwieranie", "", "Edit1")
	ControlSetText("Otwieranie", "", "Edit1", $path)
	ControlClick("Otwieranie", "", "Button1")
EndFunc